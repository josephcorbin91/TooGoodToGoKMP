package com.jco.kmp.android.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jco.kmp.features.ProductItemUIModel

@Composable
fun ProductListItem(
    product: ProductItemUIModel,
    modifier: Modifier = Modifier,
    onNavigateToProductDetail: () -> Unit,
) {
    val semanticsModifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    Card(
        modifier = semanticsModifier.clickable { onNavigateToProductDetail.invoke() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.displayImageUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = product.name,
            )

            Spacer(
                Modifier.width(30.dp)
            )
            Column {
                Text(
                    text = product.name,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.id,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
