package ke.co.svs.mykrypto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ke.co.svs.mykrypto.R
import ke.co.svs.mykrypto.domain.model.UserCryptoDetail

@Composable
fun CryptoDetailListItem(
    cryptoDetail: UserCryptoDetail,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Card(shape = RoundedCornerShape(8.dp), modifier = modifier
        .padding(all = 5.dp)
        .fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            cryptoDetail.logo?.let { url ->
                val image =
                    LoadImageFromUrl(url = url, defaultImage = R.drawable.vanamo_logo).value

                image?.let { img ->
                    Image(bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp),
                        contentScale = ContentScale.Fit,
                        contentDescription = "Logo")
                }
            }
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start) {
                CustomRow(leftText = cryptoDetail.name!!, rightText = cryptoDetail.price.toString())
                CustomRow(leftText = cryptoDetail.symbol!!,
                    rightText = cryptoDetail.percentChange24h.toString())
                CustomRow(leftText = "Quantity", rightText = cryptoDetail.myQuantity.toString())
                CustomRow(leftText = "Value", rightText = cryptoDetail.value.toString())
            }

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.then(Modifier.size(30.dp))) {
                Icon(
                    Icons.Filled.MoreVert,
                    "options",
                    tint = Color.Gray)
            }

        }
    }

}


@Composable
fun CustomRow(leftText: String, rightText: String) {

    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = leftText,
                modifier = Modifier
                    .padding(start = 16.dp),
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold
            )
        }
        Row(modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = rightText,
                modifier = Modifier
                    .padding(start = 16.dp),
                textAlign = TextAlign.Left,
            )
        }

    }
}