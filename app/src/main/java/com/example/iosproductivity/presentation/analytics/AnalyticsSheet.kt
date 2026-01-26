package com.example.iosproductivity.presentation.analytics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iosproductivity.domain.model.DailyAnalytics
import com.example.iosproductivity.presentation.components.IOSCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticsSheet(
    analytics: DailyAnalytics?,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Productivity Insights",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            
            IOSCard(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text("Daily Score", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "${analytics?.productivityScore ?: 0}%",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text("Completed: ${analytics?.completedTasks ?: 0}")
            Text("Pending: ${analytics?.pendingTasks ?: 0}")
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
