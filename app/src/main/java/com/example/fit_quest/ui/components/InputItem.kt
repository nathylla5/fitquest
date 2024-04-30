package com.example.fit_quest.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.fit_quest.ui.theme.accentLight
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun InputItem(
    lines: Int?=null,
    state: MutableState<String>,
    text: String,
    passwordVisualTransformation: VisualTransformation,
) {
    val interactionSource = remember { MutableInteractionSource() }

    TextField(
        maxLines = lines ?: 1,
        modifier = Modifier
            .fillMaxWidth()
            .width(IntrinsicSize.Min),
        shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
        value = state.value,
        onValueChange = { state.value = it },
        placeholder = {
            Text(
                modifier = Modifier.padding(5.dp),
                text = text, style = TextStyle(color = accentLight)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = containerOrTextLight,
            focusedLabelColor = primaryLight,
            unfocusedLabelColor = accentLight,
            focusedIndicatorColor = primaryLight,
            unfocusedIndicatorColor = accentLight
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        visualTransformation = passwordVisualTransformation
    )
}
