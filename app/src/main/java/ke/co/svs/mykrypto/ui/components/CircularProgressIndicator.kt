package ke.co.svs.mykrypto.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CircularProgress(
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(50.dp * 2f)
    ) {
        CircularProgressIndicator(strokeWidth = 1.dp)
    }
}
