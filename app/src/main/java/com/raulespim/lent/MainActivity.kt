package com.raulespim.lent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulespim.lent.data.LentRepository
import com.raulespim.lent.ui.theme.LentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LentApp()
                }
            }
        }
    }
}

@Composable
fun LentApp() {
    Scaffold(
        topBar = { LentTopBar(modifier = Modifier.padding(bottom = 8.dp)) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        val saintMichaelArchangelList = LentRepository.saintMichaelArchangelLentDayList
        SaintMichaelArchangelLentDayList(
            lentDayList = saintMichaelArchangelList,
            contentPadding = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LentTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.lent_name_saint_michael_archangel),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge.copy(lineHeight = 24.sp),
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun LentAppPreview() {
    LentTheme {
        LentApp()
    }
}