package com.jco.kmp.android.features.productdetails.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jco.kmp.android.R
import com.jco.kmp.android.designsystem.component.baselineHeight
import com.jco.kmp.core.domain.product.uimodel.ProductDetailUIModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProductDetailContent(
    productDetailUIModel: ProductDetailUIModel,
    nestedScrollInteropConnection: NestedScrollConnection = rememberNestedScrollInteropConnection()
) {


    val scrollState = rememberScrollState()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollInteropConnection)
            .systemBarsPadding()
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProductHeader(
                    productDetailUIModel,
                )
                UserInfoFields(productDetailUIModel, this@BoxWithConstraints.maxHeight)
            }
        }
    }
}
//
@Composable
private fun UserInfoFields(productDetailUIModel: ProductDetailUIModel, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        ProductProperty(stringResource(R.string.product_detail_brands), productDetailUIModel.brands)
        ProductProperty(
            stringResource(R.string.product_detail_allergens),
            productDetailUIModel.allergens
        )
        ProductProperty(
            stringResource(R.string.product_detail_code),
            productDetailUIModel.code
        )
        ProductProperty(
            stringResource(R.string.product_detail_productName),
            productDetailUIModel.productName
        )

        ProductProperty(
            stringResource(R.string.product_detail_energy),
            productDetailUIModel.energy
        )
        ProductProperty(
            stringResource(R.string.product_detail_grade),
            productDetailUIModel.grade
        )
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun ProductHeader(
    productDetailUIModel: ProductDetailUIModel
) {
    productDetailUIModel.displayImageUrl.let {
        AsyncImage(
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .padding(20.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(it)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = productDetailUIModel.productName,
        )
    }
}

@Composable
fun ProductProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        Text(
            text = label,
            modifier = Modifier.baselineHeight(24.dp),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        val style = if (isLink) {
            MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
        } else {
            MaterialTheme.typography.bodyLarge
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
}