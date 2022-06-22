package ke.co.svs.mykrypto.ui.components

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@Composable
fun LoadImageFromUrl(
    url: String,
    @DrawableRes defaultImage: Int,
): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = remember { mutableStateOf(null) }
    val context = LocalContext.current
    Glide.with(context)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap?>() {
            override fun onLoadCleared(placeholder: Drawable?) {}
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap?>?) {
                bitmapState.value = resource
            }

        })

    Glide.with(context)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap?>() {
            override fun onLoadCleared(placeholder: Drawable?) {}
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap?>?) {
                bitmapState.value = resource
            }
        })
    return bitmapState
}