package com.raulespim.lent

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.raulespim.lent.model.LentDay
import com.raulespim.lent.ui.theme.LentTheme

@Composable
fun SaintMichaelArchangelLentDayList(
    lentDayList: List<LentDay>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        items(lentDayList) { lentDay ->
            LentDayCard(lentDay, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun LentDayCard(lentDay: LentDay, modifier: Modifier = Modifier) {

    val isInPreview = LocalInspectionMode.current
    var expanded by rememberSaveable { mutableStateOf(isInPreview) }

    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = lentDay.title, lentDay.day),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier.size(140.dp)
            ) {
                if (isInPreview) {
                    Image(
                        painter = painterResource(id = R.drawable.saint_michael_archangel_day1),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clip(shape = MaterialTheme.shapes.small)
                    )
                } else {
                    GlideDrawableImage(drawableRes = lentDay.image, width = 140, height = 140,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clip(shape = MaterialTheme.shapes.small)
                            .clickable { expanded = !expanded }
                    )
                }
            }
            if (expanded) {
                Text(
                    text = stringResource(id = lentDay.description),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_open),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun GlideDrawableImage(
    @DrawableRes drawableRes: Int,
    width: Int,
    height: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageBitmap = remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(drawableRes) {
        Glide.with(context)
            .asBitmap()
            .load(drawableRes)
            .override(width, height)
            .into(object : CustomTarget<Bitmap>() {

                override fun onResourceReady(
                    resource: Bitmap,
                    transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                ) {
                    imageBitmap.value = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // Limpeza, se necessário
                }
            })
    }

    imageBitmap.value?.let { bitmap ->
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(width.dp, height.dp)
                .clip(shape = MaterialTheme.shapes.small)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LentDayCardPreview() {
    LentTheme {
        LentDayCard(
            lentDay = LentDay(
                day = 1,
                title = R.string.lent_day_title,
                image = R.drawable.saint_michael_archangel_day1,
                description = R.string.description_day1_saint_michael_archangel
            )
        )
    }
}