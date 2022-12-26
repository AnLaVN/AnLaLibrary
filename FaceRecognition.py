import face_recognition
import urllib.request
from typing import Final
import sys

VERSION: Final = 'v1.4.35'

# Checking verion, if invalid then exit program
try:
	RequiredVersion = urllib.request.urlopen('https://raw.githubusercontent.com/AnLaVN/AL-Library/Releases/FaceRecognitionVersion.txt')
	RequiredVersion = RequiredVersion.read().decode('utf-8').strip()
	if(RequiredVersion != VERSION):
		print('[Invalid Version]')
		print('The current version', VERSION ,'does not match the requirements of version', RequiredVersion)
		sys.exit()
except Exception as e:
	print('[Connection Error]')
	print(e)
	sys.exit()
 
# Face Recogniton and return results
try:
	imgOrig = face_recognition.load_image_file('FaceRecognition/Image/orginal.png')
	imgTest = face_recognition.load_image_file('FaceRecognition/Image/testing.png')
 
	encodeOrig = face_recognition.face_encodings(imgOrig)[0]
	encodeTest = face_recognition.face_encodings(imgTest)[0]
	results = face_recognition.compare_faces([encodeOrig],encodeTest)
	faceDis = face_recognition.face_distance([encodeOrig],encodeTest)
 
	print(results)
	print(faceDis)
except Exception as e:
	print('[Face Recognition Error]')
	print(e)