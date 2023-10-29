package com.example.pankajscanning.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun PankajScanningTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


//@Composable
//fun CinemaxTheme(
//    colorScheme: ColorScheme = DarkColorScheme,
//    shapes: Shapes = Shapes,
//    typography: Typography = Typography,
//    content: @Composable () -> Unit
//) {
//    MaterialTheme(
//        colorScheme = colorScheme,
//        shapes = shapes,
//        typography = typography
//    ) { ProvideCinemaxThemeDependencies(content = content) }
//}
//
//@Composable
//private fun ProvideCinemaxThemeDependencies(content: @Composable () -> Unit) {
//    CompositionLocalProvider(
//        LocalCinemaxColors provides CinemaxColors(),
//        LocalCinemaxShapes provides CinemaxShapes(),
//        LocalCinemaxTypography provides CinemaxTypography(),
//        LocalCinemaxSpacing provides CinemaxSpacing(),
//        LocalIndication provides rememberCinemaxRipple(),
//        LocalRippleTheme provides CinemaxRippleTheme
//    ) {
//        ProvideTextStyle(value = CinemaxTheme.typography.regular.h4, content = content)
//    }
//}
//
//object CinemaxTheme {
//    val colors: CinemaxColors
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalCinemaxColors.current
//
//    val shapes: CinemaxShapes
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalCinemaxShapes.current
//
//    val typography: CinemaxTypography
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalCinemaxTypography.current
//
//    val spacing: CinemaxSpacing
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalCinemaxSpacing.current
//}
