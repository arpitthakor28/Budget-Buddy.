$ErrorActionPreference = "Continue"
$SdkPath = "C:\Users\thako\AppData\Local\Android\Sdk"
$EmulatorPath = "$SdkPath\emulator\emulator.exe"
$AdbPath = "$SdkPath\platform-tools\adb.exe"

$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"

Write-Host "Checking for attached devices..."
$devices = & $AdbPath devices
if ($devices -notmatch "emulator-") {
    Write-Host "Starting emulator Pixel_9..."
    Start-Process -FilePath $EmulatorPath -ArgumentList "-avd Pixel_9"
    Write-Host "Waiting for emulator device..."
    & $AdbPath wait-for-device
    Write-Host "Waiting for boot to finish..."
    for ($i = 0; $i -lt 30; $i++) {
        Start-Sleep -Seconds 5
        try {
            $status = & $AdbPath shell getprop sys.boot_completed 2>$null
            if ($status -match "1") { break }
        }
        catch { }
    }
}

Write-Host "Building and installing Android app..."
.\gradlew installDebug
if ($LASTEXITCODE -ne 0) {
    Write-Error "Gradle installDebug failed."
    exit 1
}

Write-Host "Launching splash activity..."
& $AdbPath shell am start -n "com.moneyapp/com.moneyapp.SplashActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
Write-Host "Success!"
