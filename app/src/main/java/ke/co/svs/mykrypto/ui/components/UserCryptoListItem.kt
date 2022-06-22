package ke.co.svs.mykrypto.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ke.co.svs.mykrypto.domain.model.UserCrypto

@Composable
fun UserCryptoListItem(
    userCrypto: UserCrypto,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Card(shape = RoundedCornerShape(8.dp), modifier = modifier.padding(all = 5.dp)) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = userCrypto.id!!
            )

        }
    }

}
