package com.example.iosproductivity.presentation.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.iosproductivity.domain.model.Task
import com.example.iosproductivity.domain.model.TaskCategory
import com.example.iosproductivity.presentation.components.IOSCard
import com.example.iosproductivity.presentation.theme.IOSBlue
import com.example.iosproductivity.presentation.theme.IOSGrayText
import com.example.iosproductivity.presentation.theme.IOSGreen
import com.example.iosproductivity.presentation.theme.IOSOrange
import com.example.iosproductivity.presentation.theme.IOSRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(
    task: Task,
    onToggle: () -> Unit,
    onDelete: () -> Unit,
    onReschedule: () -> Unit
) {
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToEnd) {
                onToggle()
                false // Don't actually dismiss the row, just toggle state
            } else if (it == DismissValue.DismissedToStart) {
                onReschedule()
                 false
            } else {
                false
            }
        }
    )

    SwipeToDismiss(
        state = dismissState,
        notifications = {},
        directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
        background = {
            val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
            val color by animateColorAsState(
                when (dismissState.targetValue) {
                    DismissValue.DismissedToEnd -> IOSGreen
                    DismissValue.DismissedToStart -> IOSOrange
                    else -> Color.Transparent
                }, label = "ColorAnimation"
            )
            val icon = when (dismissState.targetValue) {
                DismissValue.DismissedToEnd -> Icons.Default.Check
                DismissValue.DismissedToStart -> Icons.Default.Schedule
                else -> Icons.Default.Check
            }
            val scale by animateFloatAsState(
                if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f, label = "ScaleAnimation"
            )
            val alignment = if (direction == DismissDirection.StartToEnd) Alignment.CenterStart else Alignment.CenterEnd

            Box(
                Modifier
                    .fillMaxSize()
                    .background(color)
                    .padding(horizontal = 20.dp),
                contentAlignment = alignment
            ) {
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.scale(scale),
                    tint = Color.White
                )
            }
        },
        dismissContent = {
            IOSCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onToggle) {
                        Icon(
                            imageVector = if (task.isCompleted) Icons.Filled.CheckCircle else Icons.Outlined.Circle,
                            contentDescription = "Toggle",
                            tint = if (task.isCompleted) IOSBlue else IOSGrayText
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = task.title,
                            style = MaterialTheme.typography.bodyLarge,
                            textDecoration = if (task.isCompleted) TextDecoration.LineThrough else null,
                            color = if (task.isCompleted) IOSGrayText else MaterialTheme.colorScheme.onSurface
                        )
                        if (task.category != TaskCategory.CUSTOM) {
                            Text(
                                text = task.category.name,
                                style = MaterialTheme.typography.labelMedium,
                                color = IOSGrayText
                            )
                        }
                    }
                }
            }
        }
    )
}
