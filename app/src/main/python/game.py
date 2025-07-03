import random

def check_guess(user_input, number):
    try:
        guess = int(user_input)
        if guess < number:
            return "Too low!"
        elif guess > number:
            return "Too high!"
        else:
            return "Correct!"
    except:
        return "Invalid number"
