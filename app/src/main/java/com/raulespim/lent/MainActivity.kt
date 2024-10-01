package com.raulespim.lent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        val saintMichaelArchangelList = LentRepository.saintMichaelArchangelLentDayList

        Column(Modifier.padding(innerPadding)) {
            Text(
                text = stringResource(id = R.string.lent_name_saint_michael_archangel),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            SaintMichaelArchangelLentDayList(lentDayList = saintMichaelArchangelList)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LentAppPreview() {
    LentTheme {
        LentApp()
    }
}