import re
import sys
from zhon.hanzi import punctuation


if __name__ == '__main__':
    #print(sys.path)
    text = "\，\\我爱=+你！【我//""们】~————\n\n\n结 /婚 ' 吧 : ： ！ 这 .!！_#？?（）个‘’“”￥$主|意()不错......！"
    print(text)
    print(punctuation)
    r1 = '[^\u4E00-\u9FA5 \n]'
    string = re.sub(r1,'',text)
    #string = re.sub("[\s+\.\!\/_,$%^*(+\"\']+|[+——！，。？、~@#￥%……&*（）]", "",string)
    print(string)