# -*- coding: utf-8 -*-
import json
from city import city
import urllib.request

cityname = input('你想查询哪个城市的天气？')
citycode = city[cityname]


if citycode:
    url = ('http://www.weather.com.cn/weather/%s.shtml'%citycode)
    content = urllib.request.urlopen(url).read()
    output = open('weather.html','wb')
    output.write(content)
    output.close()
