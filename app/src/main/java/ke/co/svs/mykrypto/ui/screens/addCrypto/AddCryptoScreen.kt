package ke.co.svs.mykrypto.ui.screens.addCrypto

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import ke.co.svs.mykrypto.ui.components.CircularProgress
import ke.co.svs.mykrypto.ui.theme.TextGray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun AddCryptoScreen(
    coroutineScope: CoroutineScope,
    navController: NavController,
    addCryptoViewModel: AddCryptoScreenViewModel = getViewModel<AddCryptoScreenViewModel>(),
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

    val cryptoList = addCryptoViewModel.cryptosFlow.collectAsState(initial = emptyList())



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
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        modifier = Modifier.then(Modifier.size(40.dp)),
                        onClick = { navController.popBackStack() },
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "Arrow Back",
                        )
                    }

                    Spacer(modifier = Modifier.width(5.dp))

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

                when (val state = addCryptoViewModel.uiState.collectAsState().value) {
                    is AddCryptoScreenViewModel.AddCryptoUiState.Loading ->
                        Box(modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center) {
                            CircularProgress()
                        }
                    is AddCryptoScreenViewModel.AddCryptoUiState.Empty ->
                        Box(modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center) {
                            Text(text = "No coins found")
                        }
                    is AddCryptoScreenViewModel.AddCryptoUiState.Loaded ->
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
                        ) {
                            items(cryptoList.value) { crypto ->
                                Text(text = crypto.name!!)
                            }

                        }
                    is AddCryptoScreenViewModel.AddCryptoUiState.Error ->
                        Box(modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center) {
                            Text(text = "We couldn't load \n Please refresh")
                        }

                }

            }

        }
    }
}