# python3

from collections import namedtuple

Bracket = namedtuple("Bracket", ["char", "position"])


def are_matching(left, right):
    return (left + right) in ["()", "[]", "{}"]

def find_mismatch(text):
    opening_brackets_stack = []
    for i, char in enumerate(text, start=1):
        if char in "([{":
            opening_brackets_stack.append(Bracket(char, i))
        elif char in ")]}":
            if not opening_brackets_stack: #if stack is empty, "[])"
                return i
            top = opening_brackets_stack.pop()
            if not are_matching(top.char, char):
                return i
    if opening_brackets_stack: #example: only "[", 
        top = opening_brackets_stack.pop()
        return top.position
    return "Success"

def main():
    text = input()
    mismatch = find_mismatch(text)
    print(mismatch)


if __name__ == "__main__":
    main()
