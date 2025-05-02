package ru.mrapple100.mapsretrofit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.mrapple100.mapsretrofit.network.SingletoneRetrofit

@Composable
fun TagsScreen(
    tagsViewModel: TagsViewModel
) {
    val tags  = tagsViewModel._tagsStateFlow.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(onClick = { tagsViewModel.fetchTags() }) {

        }

        if (tags.value != null)
            LazyColumn {
                items(tags.value!!) { tag ->

                    Card {
                        Text(text = tag.description)
                    }
                }
            }
    }


}