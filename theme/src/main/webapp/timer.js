let timer;
let remainingTime = 0;
const timeInSeconds = 5;//実際は１時間(3600秒)で入力必要
let isPaused = false;

function checkConditions() {
    var submitButton = document.getElementById('submitButton');
}

function preloadAudio(url) {
    const audio = new Audio(url);
    audio.preload = 'auto';
    audio.load();
}

const soundURL = "sound\Low-Alarm.mp3";
preloadAudio(soundURL, () => {
    // 読み込み完了後に実行したい処理をここに記述
    console.log('音声ファイルの読み込みが完了しました！');
});

function startTimer() {
    audio.play();
    if (isPaused) {
        isPaused = false;
        updateTimer();
    } else {
        stopTimer();
        remainingTime = timeInSeconds;
        isPaused = false;
        updateTimer();
    }
}

const audio = new Audio("sound\Low-Alarm.mp3");
function playTimer() {
    audio.play();
}

function pauseTimer() {
    isPaused = true;
    stopTimer();
}

function updateTimer() {
    const timerDisplay = document.getElementById('timerDisplay');

    if (!isPaused) {
        const minutes = Math.floor(remainingTime / 60);
        const seconds = remainingTime % 60;

        const displayMinutes = String(minutes).padStart(2, '0');
        const displaySeconds = String(seconds).padStart(2, '0');

        timerDisplay.textContent = `残り時間: ${displayMinutes}:${displaySeconds}`;

        if (remainingTime <= 0) {
            stopTimer();
            playTimer();
            alert('終了！');
            submitButton.style.display = 'block';
        } else {
            remainingTime--;
            timer = setTimeout(updateTimer, 1000);
            submitButton.style.display = 'none';
        }
    }
}

function stopTimer() {
    if (timer) {
        clearTimeout(timer);
    }
}