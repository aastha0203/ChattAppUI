package com.example.uigossip.Screens



import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uigossip.Navigation.Chat_Screen
import com.example.uigossip.R
import com.example.uigossip.commonComponents.IconComponent
import com.example.uigossip.commonComponents.IconComponentDrawable
import com.example.uigossip.commonComponents.SpacerHeight
import com.example.uigossip.commonComponents.SpacerWidth
import com.example.uigossip.data.Person
import com.example.uigossip.data.personList
import com.example.uigossip.ui.theme.DarkGray_1
import com.example.uigossip.ui.theme.Gray
import com.example.uigossip.ui.theme.Gray400
import com.example.uigossip.ui.theme.Line

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(){

    }
}


@Composable
fun HomeScreen(
    onClick: (person: Person) -> Unit
) {
    var search by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            Header()
            SpacerHeight(20.dp)
            SearchBarScreen(text = search, onValueChange ={search=it} )
            SpacerHeight(35.dp)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.White, RoundedCornerShape(
                            topStart = 30.dp, topEnd = 30.dp
                        )
                    )
            ) {


                BottomSheetSwipeUp(
                    modifier = Modifier
                        .align(TopCenter)
                        .padding(top = 15.dp)
                )
                SpacerWidth(30.dp)
                SpacerHeight(70.dp)
                LazyColumn(
                    modifier = Modifier.padding(bottom = 15.dp, top = 30.dp)
                ) {
                    items(personList, key = { it.id }) {
                        UserEachRow(person = it) {
                            onClick(it)
                        }
                    }
                }
            }
        }

    }

}





@Composable
fun BottomSheetSwipeUp(
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .background(
                Gray400,
                RoundedCornerShape(90.dp)
            )
            .width(90.dp)
            .height(5.dp)

    )
}


@Composable
fun UserEachRow(
    person: Person,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .noRippleEffect { onClick() }
            .padding(horizontal = 20.dp, vertical = 5.dp),
    ) {
        Column {

            Row(

                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconComponentDrawable(icon = person.icon, size = 60.dp)
                    SpacerWidth()
                    Column {
                        Text(
                            text = person.name, style = TextStyle(
                                color = Color.Black, fontSize = 15.sp, fontWeight = FontWeight.Bold
                            )
                        )
                        SpacerHeight(5.dp)
                        Text(
                            text = stringResource(R.string.okay), style = TextStyle(
                                color = Gray, fontSize = 14.sp
                            )
                        )
                    }

                }
                Text(
                    text = stringResource(R.string._12_23_pm), style = TextStyle(
                        color = Gray, fontSize = 12.sp
                    )
                )
            }
            SpacerHeight(15.dp)
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Line)
        }
    }

}





@Composable
fun Header() {


    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
        ) {
            append(stringResource(R.string.welcome_back))
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        ) {
            append(stringResource(R.string.Aastha))
        }
    }

    Text(text = annotatedString)

}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.noRippleEffect(onClick: () -> Unit) = composed {
    clickable(
        interactionSource = MutableInteractionSource(),
        indication = null
    ) {
        onClick()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBarScreen(
    text: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier
) {

    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search), style = TextStyle(
                    color = DarkGray_1, fontSize = 16.sp, fontWeight = FontWeight.W400
                )
            )
        },
        leadingIcon = {
            IconComponent(icon = R.drawable.baseline_search_24)
        },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        
    )

}