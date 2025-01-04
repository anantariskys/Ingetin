import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ingetin.ui.theme.Primary
import com.example.ingetin.ui.theme.Secondary

@Composable
fun CustomButton(
    text: String = "Login",
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Primary, // Default purple color
    textColor: Color = Color.White,
    cornerRadius: Dp = 8.dp
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(cornerRadius),
        modifier = modifier
            .width(300.dp)
            .height(50.dp)

    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
   Column {
       CustomButton(
           text = "Register",
           onClick = { /* Do nothing for preview */ },
           backgroundColor = Primary,
           textColor = Color.White
       )
       Spacer(modifier = Modifier.height(16.dp))
       CustomButton(
           text = "Send",
           onClick = { /* Do nothing for preview */ },
           backgroundColor = Secondary,
           textColor = Color.White
       )
   }
}
