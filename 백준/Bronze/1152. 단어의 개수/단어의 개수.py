text = input().split(" ")
if text[0] == "" and text[-1] == "":
    print(len(text)-2)
elif text[0] == "" or text[-1] == "":
    print(len(text)-1)
else:
    print(len(text))