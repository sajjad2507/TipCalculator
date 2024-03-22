package com.example.tipcalculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun CustomButton(imageVector: ImageVector, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp)
            .clickable {

                onClick.invoke()

            }, shape = CircleShape
    ) {

        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(4.dp)
        )

    }
}

fun getTipAmount(userAmount: String, tipPercentage: Float): String {

    return when {
        userAmount.isEmpty() -> {
            "0"
        }

        else -> {
            val amount = userAmount.toFloat()
            (amount * tipPercentage.div(100)).toString()
        }
    }

}

fun getTotalHeaderAmount(userAmount: String, tipPercentage: Float, personCounter: Int): String {


    return when {
        userAmount.isEmpty() -> {
            "0"
        }

        else -> {
            val amount = userAmount.toFloat()
            val tipAmount = amount * tipPercentage.div(100)
            val perHeadAmount = (amount + tipAmount).div(personCounter)
            perHeadAmount.toString()
        }
    }

}

fun formatTwoDecimalPoints(str: String): String {

    return if (str.isEmpty()) {
        ""
    } else {
        val format = DecimalFormat("######################.##")
        format.format(str.toFloat())
    }

}