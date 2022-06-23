package ke.co.svs.mykrypto.ui.components


import android.graphics.Insets.min
import android.util.Log
import android.view.WindowInsets
import android.view.WindowInsets.Type.systemBars
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ke.co.svs.mykrypto.R
import ke.co.svs.mykrypto.ui.theme.Shapes
import ke.co.svs.mykrypto.utils.AppBarCollapsedHeight
import ke.co.svs.mykrypto.utils.AppBarExpandedHeight
import ke.co.svs.mykrypto.utils.GradientOne
import ke.co.svs.mykrypto.utils.Routes
import kotlin.math.max
import kotlin.math.min


@Composable
fun CollapsingToolBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val scrollState = rememberLazyListState()
    val title: String
    when (currentRoute) {
        Routes.ROUTE_HOME -> title = "Cryponite"
        Routes.ROUTE_CHARTS -> title = "Charts"
        Routes.ROUTE_ALERTS -> title = "Alerts"
        Routes.ROUTE_SETTINGS -> title = "Settings"
        else -> title = "Cryponite"
    }


    Box {
        AccountInfo(scrollState)
        ProfileToolBar(scrollState)
    }
}



@Composable
fun ProfileToolBar(scrollState: LazyListState) {
    val imageHeight = AppBarExpandedHeight - AppBarCollapsedHeight

    val maxOffset =
        with(LocalDensity.current) { imageHeight.roundToPx() }.minus(WindowInsets.Side.TOP)

    val offSet = min(scrollState.firstVisibleItemScrollOffset, maxOffset)
    val offsetProgress = max(0f, offSet * 3f - 2f * maxOffset)

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier
            .height(AppBarExpandedHeight)
            .offset { IntOffset(x = 0, y = -offSet) },
        elevation = if (offSet == maxOffset) 4.dp else 0.dp
    ) {

        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight)
                    .graphicsLayer { alpha = 1f - offsetProgress }
                    .background(Brush.horizontalGradient(
                        listOf(GradientOne, GradientOne)
                    )
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.vanamo_logo),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(100.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "Title",
                            fontSize = 25.sp,
                            color = Color.White,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(2.dp)
                        )

                    }
                }
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Contact Info",
                    fontSize = 25.sp,
                    color = Color.Black,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = (16 + 28 * offsetProgress).dp)
                        .scale(1f - 0.25f * offsetProgress)
                )
            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(AppBarCollapsedHeight)
            .padding(horizontal = 16.dp)
    ) {
        Button(onClick = { /*TODO*/ },
            contentPadding = PaddingValues(),
            shape = Shapes.small,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White,
                contentColor = Color.Gray),
            elevation = ButtonDefaults.elevation(),
            modifier = Modifier
                .width(38.dp)
                .height(38.dp)
        ) {
            Icon(imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp),
                tint = Color.Black)

        }
    }
}



@Composable
fun AccountInfo(scrollState: LazyListState) {

}