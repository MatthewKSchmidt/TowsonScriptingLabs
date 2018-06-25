import urllib
from bs4 import BeautifulSoup

page = urllib.urlopen('https://www.uszip.com/zip/21128')

pop_text = page.read()
pop_where = pop_text.find('<dt>Total population</dt>')
pop_start = pop_where + 29
pop_end = pop_start + 6
pop_data = pop_text[pop_start:pop_end]
print 'Population of White Marsh, MD: ', pop_data
