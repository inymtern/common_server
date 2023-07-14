import pyaudio
import wave

CHUNK = 1024
FORMAT = pyaudio.paInt16
CHANNELS = 2
RATE = 44100
RECORD_SECONDS = 5
OUTPUT_FILE = "./result/test.wav"

p = pyaudio.PyAudio()
    # 打开音频流
stream = p.open(format=FORMAT,
                    channels=CHANNELS,
                    rate=RATE,
                    input=True,
                    frames_per_buffer=CHUNK)
frames = []
def toRecord():
    print("开始录音...")
    # 录制音频数据
    for i in range(0, int(RATE / CHUNK * RECORD_SECONDS)):
        data = stream.read(CHUNK)
        frames.append(data)
    
def stopRecord():
    # 停止音频流
    stream.stop_stream()
    stream.close()
    p.terminate()
    # 将录制的音频数据保存到文件
    wf = wave.open(OUTPUT_FILE, "wb")
    wf.setnchannels(CHANNELS)
    wf.setsampwidth(p.get_sample_size(FORMAT))
    wf.setframerate(RATE)
    wf.writeframes(b"".join(frames))
    wf.close()
    print(f"音频文件已保存为 {OUTPUT_FILE}")
