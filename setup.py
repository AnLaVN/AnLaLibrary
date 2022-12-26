import cx_Freeze

exe = [cx_Freeze.Executable("FaceRecognition.py", base = None)] # <-- HERE

cx_Freeze.setup(
	name = "Face Recognition",
	version = "v1.4.35",
	description = 'Face Recognition - Nhận dạng khuôn mặt',
	options = {"build_exe": {"packages": ["face_recognition", "urllib.request", "typing", "sys"]}},
	executables = exe
)
#python setup.py build