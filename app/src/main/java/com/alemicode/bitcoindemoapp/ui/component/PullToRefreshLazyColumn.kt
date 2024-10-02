package com.alemicode.bitcoindemoapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshLazyColumn(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState()
) {
    // Remember the PullToRefresh state
    val pullToRefreshState = rememberPullToRefreshState()

    // Box layout to contain the LazyColumn and PullToRefresh logic
    Box(
        modifier = modifier
            .nestedScroll(pullToRefreshState.nestedScrollConnection) // Handle nested scroll events
            .fillMaxSize()
    ) {
        // LazyColumn with item padding and spacing
        LazyColumn(
            state = lazyListState,
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                content() // Display provided content
            }
        }

        // Trigger onRefresh callback when pull-to-refresh is active
        if (pullToRefreshState.isRefreshing) {
            LaunchedEffect(pullToRefreshState.isRefreshing) {
                onRefresh()
            }
        }

        // Manage refresh state transitions
        LaunchedEffect(isRefreshing) {
            if (isRefreshing) {
                pullToRefreshState.startRefresh()
            } else {
                pullToRefreshState.endRefresh()
            }
        }

        // Display the PullToRefreshContainer aligned at the top
        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
