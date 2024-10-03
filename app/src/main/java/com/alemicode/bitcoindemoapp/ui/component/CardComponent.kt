package com.alemicode.bitcoindemoapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    walletAddress: String = "",
    transactionId: String = "",
    status: Boolean? = true,
    amount: Int = 0
) {

    val transactionStatus = status ?: false
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 40.dp)
            .heightIn(min = 220.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(width = 1.dp, color = Color.Black)
            .padding(horizontal = 50.dp, vertical = 20.dp)
    ) {


        Text(
            text = "Transaction ID is $transactionId",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
        )

        Text(
            text = walletAddress,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            NotificationDot(
                color = if (transactionStatus) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error
            )
            Text(" Status of this transaction is $transactionStatus")
        }
        Text(" Amount of BTC transaction ${amount / 1000}", style = MaterialTheme.typography.bodyMedium)

    }
}

@Composable
fun NotificationDot(
    color: Color,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier
            .semantics { contentDescription = "" },
        onDraw = {
            drawCircle(
                color,
                radius = size.minDimension / 2,
            )
        },
    )
}