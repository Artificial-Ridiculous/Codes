def isMatch(text, pattern) -> bool:
    if not pattern: return not text
    first_match = bool(text) and pattern[0] in {text[0], '.'}
    if len(pattern) >= 2 and pattern[1] == '*':
        # 发现 '*' 通配符
        if len(pattern) >= 2 and pattern[1] == '*':
            return isMatch(text, pattern[2:]) or first_match and isMatch(text[1:], pattern)
    else:
        return first_match and isMatch(text[1:], pattern[1:])

if __name__ == '__main__':
    s = "aaab"
    p = "a*b"
    res = isMatch(s,p)
    print(res)
