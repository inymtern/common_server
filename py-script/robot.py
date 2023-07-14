import pyautogui 
import sounddevice as sd
import time
# from audio import toRecord, stopRecord
pyautogui.PAUSE = 1


# 找图片位置
def findImg(img):
    image_location = pyautogui.locateOnScreen(img)
    center_x = image_location.left + (image_location.width // 2)
    center_y = image_location.top + (image_location.height // 2)
    return center_x, center_y

# 全选
def ctrl_a():
    pyautogui.keyDown('ctrl')
    pyautogui.keyDown('a')
    pyautogui.keyUp('a')
    pyautogui.keyUp('ctrl')

# 朗读快捷键
def ctrl_shift_u():
    pyautogui.keyDown('ctrl')
    pyautogui.keyDown('shift')
    pyautogui.keyDown('u')
    pyautogui.keyUp('u')
    pyautogui.keyUp('shift')
    pyautogui.keyUp('ctrl')

# 开始录制/停止 
def alt_f9():
    pyautogui.hotkey('alt','f9')


# 判断是否结束
def check_finished(call):
    max_sec = 180
    cur_sec = 0
    finished = 0
    time.sleep(3)
    while(finished == 0 and cur_sec < max_sec):
        time.sleep(2)
        print('开始判断是否结束...')
        x,y = findImg('./img/pause.png')
        if(x != None and y != None):
            print("音频录制结束...")
            break
        else:
            print("音频尚未结束...")

    call()



def main():

    # 找到edge图标
    x, y = findImg('./img/edge.png')
    # 移动到
    pyautogui.moveTo(x, y)
    # 点击
    pyautogui.click()
    # 执行ctrl + A全选
    ctrl_a()
    # 执行朗读
    ctrl_shift_u()

    # 录制声音
    # toRecord()
    # 检测是否结束
    # check_finished(stopRecord)


if __name__ == "__main__":
    main()