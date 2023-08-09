package com.rodrigoguerrero.myweather.android.ui.preview.data

import com.rodrigoguerrero.myweather.ui.models.uimodels.HourUi
import com.rodrigoguerrero.myweather.ui.models.uistate.TodayWeatherUiState
import com.rodrigoguerrero.mywheather.MR




// Preview Data
val todayWeatherUiState: TodayWeatherUiState = TodayWeatherUiState(
    currentTime = "9 August, 11:00",
    currentTemperature = "30",
    feelsLikeTemperature = "35",
    condition="Partly cloudy",
    conditionIconUrl="https://cdn.weatherapi.com/weather/64x64/day/116.png",
    hourlyForecasts=
    listOf(
        HourUi(
            hour="11:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/356.png",
            temperature="28", chanceOfRain="77", precipitationMmPercentage=0.9, dewPoint="22",
            precipitationMm="2.7", windSpeed=12, windDirection="SE", windDirectionDegrees=322),
        HourUi(hour="12:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/176.png",
            temperature="28", chanceOfRain="77", precipitationMmPercentage=0.3333333333333333,
            dewPoint="22", precipitationMm="1.0", windSpeed=12, windDirection="SSE",
            windDirectionDegrees=335),
        HourUi(hour="13:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/353.png",
            temperature="29", chanceOfRain="87", precipitationMmPercentage=0.26666666666666666,
            dewPoint="22", precipitationMm="0.8", windSpeed=14, windDirection="SSE",
            windDirectionDegrees=341),
        HourUi(hour="14:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/356.png",
            temperature="29", chanceOfRain="74", precipitationMmPercentage=1.0, dewPoint="22",
            precipitationMm="4.6", windSpeed=14, windDirection="S", windDirectionDegrees=355),
        HourUi(hour="15:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/176.png",
            temperature="29", chanceOfRain="70", precipitationMmPercentage=0.16666666666666666,
            dewPoint="22", precipitationMm="0.5", windSpeed=15, windDirection="S",
            windDirectionDegrees=356),
        HourUi(hour="16:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/176.png",
            temperature="29", chanceOfRain="56", precipitationMmPercentage=0.13333333333333333,
            dewPoint="22", precipitationMm="0.4", windSpeed=16, windDirection="SSE",
            windDirectionDegrees=344),
        HourUi(hour="17:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/353.png",
            temperature="28", chanceOfRain="89", precipitationMmPercentage=0.5333333333333333,
            dewPoint="23", precipitationMm="1.6", windSpeed=16, windDirection="SSE", windDirectionDegrees=329),
        HourUi(hour="18:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/176.png",
            temperature="28", chanceOfRain="61", precipitationMmPercentage=0.13333333333333333,
            dewPoint="23", precipitationMm="0.4", windSpeed=15, windDirection="SE", windDirectionDegrees=320),
        HourUi(hour="19:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/176.png",
            temperature="28", chanceOfRain="81", precipitationMmPercentage=0.09999999999999999,
            dewPoint="23", precipitationMm="0.3", windSpeed=14, windDirection="SE", windDirectionDegrees=316),
        HourUi(hour="20:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/176.png",
            temperature="28", chanceOfRain="66", precipitationMmPercentage=0.3, dewPoint="23", precipitationMm="0.9", windSpeed=14, windDirection="SE", windDirectionDegrees=319),
        HourUi(hour="21:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/113.png",
            temperature="28", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=14, windDirection="SE", windDirectionDegrees=324),
        HourUi(hour="22:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/113.png",
            temperature="28", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=15, windDirection="SE", windDirectionDegrees=322),
        HourUi(hour="23:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/116.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=15, windDirection="SE", windDirectionDegrees=317),
        HourUi(hour="00:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/116.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=15, windDirection="SE", windDirectionDegrees=306),
        HourUi(hour="01:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/176.png",
            temperature="27", chanceOfRain="82", precipitationMmPercentage=0.03333333333333333,
            dewPoint="23", precipitationMm="0.1", windSpeed=15, windDirection="SE", windDirectionDegrees=309),
        HourUi(hour="02:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/113.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=16, windDirection="SE", windDirectionDegrees=312),
        HourUi(hour="03:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/113.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=16, windDirection="SE", windDirectionDegrees=310),
        HourUi(hour="04:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/113.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=15, windDirection="SE", windDirectionDegrees=309),
        HourUi(hour="05:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/176.png",
            temperature="27", chanceOfRain="59", precipitationMmPercentage=0.5333333333333333,
            dewPoint="23", precipitationMm="1.6", windSpeed=15, windDirection="SE", windDirectionDegrees=307),
        HourUi(hour="06:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/113.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=14, windDirection="SE", windDirectionDegrees=312),
        HourUi(hour="07:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/night/176.png",
            temperature="27", chanceOfRain="67", precipitationMmPercentage=0.13333333333333333,
            dewPoint="23", precipitationMm="0.4", windSpeed=14, windDirection="SE", windDirectionDegrees=316),
        HourUi(hour="08:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/113.png",
            temperature="27", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=13, windDirection="SE", windDirectionDegrees=321),
        HourUi(hour="09:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/176.png",
            temperature="28", chanceOfRain="60", precipitationMmPercentage=0.03333333333333333,
            dewPoint="23", precipitationMm="0.1", windSpeed=13, windDirection="SSE", windDirectionDegrees=330),
        HourUi(hour="10:00", iconUrl="https://cdn.weatherapi.com/weather/64x64/day/113.png",
            temperature="28", chanceOfRain="0", precipitationMmPercentage=0.0, dewPoint="23", precipitationMm="0.0", windSpeed=13, windDirection="SSE", windDirectionDegrees=331)
    ),
    rainChance="89", humidity="70", dewPoint="22", pressure="1014", uvIndex="6", visibility="10",
    totalPrecipitation="20.4", windSpeed=12, windDirectionDegrees=322, windDirection= MR.strings.wind_speed_moderate, sunrise="07:05 am",
    sunset="07:15 pm", moonrise="01:00 am", moonset="01:28 pm", query="Singapore")