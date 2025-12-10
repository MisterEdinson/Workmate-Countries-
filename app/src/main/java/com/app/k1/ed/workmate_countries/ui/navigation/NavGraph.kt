package com.app.k1.ed.workmate_countries.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.k1.ecu_flash.ui.screens.auth.splash.SplashScreen
import com.app.k1.ed.workmate_countries.ui.screens.MainViewModel
import com.app.k1.ed.workmate_countries.ui.screens.detailscountry.DetailsCountryScreen
import com.app.k1.ed.workmate_countries.ui.screens.listcountry.ListCountryScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: MainViewModel
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.ListCountryScreen.route
    ) {
        animatedComposable(Screens.ListCountryScreen.route) {
            ListCountryScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        animatedComposable(Screens.DetailsCountryScreen.route) {
            DetailsCountryScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideInVertically(
            initialOffsetY = { 400 },
            animationSpec = tween(
                durationMillis = 300,
                easing = FastOutSlowInEasing
            )
        ) + fadeIn(animationSpec = tween(300))
    },
    exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutVertically(
            targetOffsetY = { -400 },
            animationSpec = tween(
                durationMillis = 300,
                easing = FastOutSlowInEasing
            )
        ) + fadeOut(animationSpec = tween(300))
    },
    popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = enterTransition,
    popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = exitTransition,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        arguments = arguments,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition
    ) { backStackEntry ->
        content(backStackEntry)
    }
}