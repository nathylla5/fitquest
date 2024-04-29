package com.example.fit_quest.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fit_quest.ui.theme.accentLight
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.textLight

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun InputItem(
    data: MutableState<String>,
    text: String,
    passwordVisualTransformation: VisualTransformation,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = data.value, onValueChange = { data.value = it },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = textLight,
            fontSize = 16.sp,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        decorationBox = { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = data.value,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = passwordVisualTransformation,
                interactionSource = interactionSource,
                placeholder = { Text(text, modifier = Modifier.padding(0.dp)) },
                contentPadding = PaddingValues(4.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = containerOrTextLight,
                    focusedLabelColor = primaryLight,
                    unfocusedLabelColor = accentLight,
                    focusedIndicatorColor = primaryLight,
                    unfocusedIndicatorColor = accentLight
                    )
            )
        }
    )
}

/*
TextField(
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
}*/