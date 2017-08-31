#!/usr/bin/python
import json
from urllib.request import urlopen
from bs4 import BeautifulSoup
url = "https://www.fedex.com/apps/fedextrack/?action=track&tracknumbers=744668909687/"
html = urlopen(url)
#Reading the contents of the file in soup
soup= BeautifulSoup(html.read(),"lxml")
print (soup)
ship_date = soup.find('div', attrs={'class': 'snapshotController_date orig'})
tracking_no = soup.find('div', attrs={'class': 'shipmentTitleBar_label_track_nick'})
delivered_status = soup.find('div', attrs={'class': 'statusChevron_key_status'})
scheduled_delivery= soup.find('div', attrs={'snapshotController_date dest'})
print (ship_date)
print (tracking_no)
print (delivered_status )
print (scheduled_delivery)
data = {
   'tracking no' : tracking_no ,
   'ship date' : ship_date,
   'status' : delivered_status,
   'scheduled delivery' :scheduled_delivery
}
#fetching  second url
url = "https://www.fedex.com/apps/fedextrack/?action=track&trackingnumber=744668911595/"
html = urlopen(url)
#Reading the contents of the file in soup
soup= BeautifulSoup(html.read(),"lxml")
print (soup)
ship_date1 = soup.find('div', attrs={'class': 'snapshotController_date orig'})
tracking_no1 = soup.find('div', attrs={'class': 'shipmentTitleBar_label_track_nick'})
delivered_status1 = soup.find('div', attrs={'class': 'statusChevron_key_status'})
scheduled_delivery1= soup.find('div', attrs={'snapshotController_date dest'})
print (ship_date1)
print (tracking_no1)
print (delivered_status1)
print (scheduled_delivery1)
data2 = {
   'tracking no' : tracking_no1 ,
   'ship date' : ship_date1,
   'status' : delivered_status1,
   'scheduled delivery' :scheduled_delivery1
}
#printing the json
print(json.dumps(data))
print(json.dumps(data2))
