package com.learning.whatsappclone.presentation.view.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.learning.whatsappclone.presentation.view.main.MainActivity

class MobileNumberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Body()
            }
        }
    }
}

@Composable
private fun Body() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        EnterYouNumberText()
        WhatsMyNumberText()
        Spacer(modifier = Modifier.weight(1f))
        NextButton()
    }
}

@Composable
fun EnterYouNumberText() {
    Text(
        text = "Enter your phone number",
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 20.dp),
    )
}

@Composable
fun WhatsMyNumberText() {
    Text(
        text = buildAnnotatedString {
            append("WhatsApp will need to verify your phone number.")
            withStyle(style = SpanStyle(Color.Blue)) {
                append(text = " What’s \n my number?")
            }
        },
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontSize = 12.sp,
        modifier = Modifier.padding(top = 20.dp),
    )
}

@Composable
fun NextButton() {
    val context = LocalContext.current
    Box(Modifier.padding(10.dp)) {
        Button(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            },
            Modifier
                .height(50.dp)
                .width(150.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Next", fontSize = 16.sp)
        }
    }
}