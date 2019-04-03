#查找所有s开头e结尾的单词

import re

f = open('qq.txt',encoding = 'utf-8-sig')
lines = f.readlines()
f.close()

text1 = ' '.join(lines)
#print(text1)

#text = "site sea sue sweet see case sse ssee loses"


#m = re.findall(r"\bs\S*?e\b", text)

m1 = re.findall(r"[^的]白富美q{2}|Q{2}:\d{5,12}\b", text1)

if m1:

    print (m1)

else:

    print ('not match')
