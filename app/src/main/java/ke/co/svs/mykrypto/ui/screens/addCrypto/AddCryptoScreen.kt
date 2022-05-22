package ke.co.svs.mykrypto.ui.screens.addCrypto

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.co.svs.mykrypto.ui.theme.TextGray
import ke.co.svs.mykrypto.ui.theme.TextWhite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun AddCryptoScreen(
    coroutineScope: CoroutineScope,
) {
    val scaffoldHostState = rememberScaffoldState()
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    var selectedCoin by remember { mutableStateOf("") }
    var query by remember { mutableStateOf(TextFieldValue("")) }

    val keyboardController = LocalSoftwareKeyboardController.current

    val closeSheet = {
        coroutineScope.launch { modalBottomSheetState.hide() }
    }

    val openSheet = {
        selectedCoin = "BITCOIN"
        coroutineScope.launch { modalBottomSheetState.show() }
    }



    Scaffold(scaffoldState = scaffoldHostState) {
        ModalBottomSheetLayout(
            sheetShape = RoundedCornerShape(20.dp),
            sheetElevation = 10.dp,
            sheetState = modalBottomSheetState,
            sheetBackgroundColor = Color.White,
            sheetContent = {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Selected", fontSize = 12.sp, color = TextGray)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Quantity", fontSize = 12.sp, color = TextGray)
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }) {
            Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = query,
                        onValueChange = { newValue -> query = newValue },
                        label = { Text(text = "Search") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Search
                        ),
                        leadingIcon = {
                            Icon(Icons.Filled.Search,
                                contentDescription = "Search Icon")
                        },

                        keyboardActions = KeyboardActions(
                            onSearch = {
                                keyboardController?.hide()
                            }),
                        textStyle = TextStyle(color = Color.Black),
                    )
                }
            }

        }
    }
}