package com.hussein.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "Hussein Kamal" , modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(highlights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.story1),
                text = "Android"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story2),
                text = "Kotlin"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story3),
                text = "JetpackCompose"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story4),
                text = "Nature"
            )

        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_profile),
                    text = "Profile"
                ),
            )
        ){
            selectedTabIndex = it //This new implementation for calling Unit method  not to add it as parameter but add it inside view it self and detect position
        }
        when (selectedTabIndex){
            0 -> {
                PostSection(
                    post = listOf(
                        painterResource(id = R.drawable.post1),
                        painterResource(id = R.drawable.post2),
                        painterResource(id = R.drawable.post3),
                        painterResource(id = R.drawable.post4),
                        painterResource(id = R.drawable.post5),
                        painterResource(id = R.drawable.post6),
                        painterResource(id = R.drawable.post7),
                        painterResource(id = R.drawable.post8),
                        painterResource(id = R.drawable.post9)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            //You can complete add Reels,IGTV ,Profile Section here
        }
    }
}

@Composable
fun TopBar(
    name:String,
    modifier: Modifier = Modifier

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bill),
            contentDescription = "Bill",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.dots),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}


@Composable
fun ProfileSection()
{
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            RoundedImage(
                image = painterResource(id = R.drawable.hussein),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StateSection(modifier = Modifier.weight(7f))

        }
        ProfileDescription(displayName = "Software Engineer",
            description = "10 years of programming experience\n" +
                "want me to make app? send me an email\n"
            +"Follow me to get all news",
            url = "https://www.linkedin.com/in/hussein-kamal-4a9428111/",
            followedBy = listOf("Asser","Mohamed", "Mostafa"),
            otherCount = 1000)
    }
}

@Composable
fun RoundedImage(
    image:Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StateSection(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ProfileState(numberText = "1000" , text = "Posts")
        ProfileState(numberText = "100K" , text = "Followers")
        ProfileState(numberText = "400" , text = "Following")

    }
}

@Composable
fun ProfileState(
    numberText : String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName : String,
    description:String,
    url:String,
    followedBy:List<String>,
    otherCount : Int
){
   val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Text(text = displayName, fontWeight = FontWeight.Bold,letterSpacing = letterSpacing , lineHeight = lineHeight)
        Text(text = description,letterSpacing = letterSpacing , lineHeight = lineHeight)
        Text(text = url, color = Color(0xFF3D3D91),letterSpacing = letterSpacing , lineHeight = lineHeight)
        if(followedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                append("Followed By ")
                followedBy.forEachIndexed{index,name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if(index < followedBy.size-1) {
                        append(",")
                    }
                }
                if(otherCount > 2){
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}


@Composable
fun ButtonSection(
    modifier : Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier : Modifier = Modifier,
    text: String? = null,
    icon:ImageVector? = null
){
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp))
    {
        if(text != null){
            Text(text = text , fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if(icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }

    }
}
@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
){
    //Horizontal recyclerView
    LazyRow(modifier = modifier){
        items(highlights.size) {
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ){
                RoundedImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                 )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed{ index,imageWithText ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick =
                {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = imageWithText.image,
                    contentDescription = "Posts",
                    tint = if(selectedTabIndex == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(
    post : List<Painter>,
    modifier: Modifier = Modifier

){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)//This push post of images to start of screen
    ){
        items(post.size){
            Image(
                painter = post[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                    )
            )
        }
    }
}







