const YourGPT_Config = {	// Thay đổi giá trị cấu hình phù hợp với bạn - Change the config value as appropriate for you
	host: "http://localhost:3000",			// [url] 				Địa chủ máy chủ của YourGPT - YourGPT server address
	logo: "logo_icon.png",					// [url of path] 		Logo hiển thị của YourGPT - YourGPT display logo
	element: "#YourGPT",					// [query]				Phần tử sẽ chèn YourGPT vào - The element to which YourGPT will be inserted -
	pattern: "pattern-dark.png",			// [url of path]		Hình nền pattern - Pattern wallpaper
	name: "YourGPT Assistant",				// [text]				Tên hiển thị của YourGPT - YourGPT display name
	tutorial: "Let ask YourGPT anything...",// [text]				Hướng dẫn nhỏ - Small guide
	setting_icon: "bi-gear",				// [bootstrap icon]		Icon menu cài đặt - Setting menu icon
	send_icon: "bi-arrow-up-right-circle",	// [bootstrap icon]		Icon gửi tin nhắn - Message sending icon
	delete_icon: "bi-trash",				// [bootstrap icon]		Icon xoá tin nhắn - Message deletion icon
	download_icon: "bi-cloud-download",		// [bootstrap icon]		Icon tải tin nhắn - Message download icon
	delete_message: "Delete chat",			// [text] 				Tiêu đề xoá tin nhắn - Message deletion title
	download_message: "Download chat",		// [text] 				Tiêu đề tải tin nhắn - Message download title
	download_file: "YourGPT Conversations",	// [text] 				Tên file tải tin nhắn - Message download file name
	datetime_format: "HH:mm | MMM dd",		// [DateTime pattern]	Định dạng ngày giờ - Date time format
	width: "90%",							// [percent] 			Chiều dài bong bóng chat - Chat bubble length
	user_text: "light",						// [bootstrap colors]	Màu chữ bong bóng chat của người dùng - User chat bubble text color
	user_color: "#A15BFC",//primary			// [bootstrap bg-color or HEX] Màu icon gửi tin nhắn và bong bóng chat của người dùng - Color of send message icon and user chat bubble
	user_avatar: "https://github.com/AnLaVN.png",			// [url of path] 	Avatar hiển thị của người dùng - User displayed avatar
	title_message: "YourGPT Notification",					// [text] 	Tiêu đề thông báo - Notification title
	clear_message: "Are you want to delete this chat?",		// [text] 	Xác nhận xoá tin nhắn - Confirm delete message
	error_message: "YourGPT got error, please try later !", // [text] 	Nội dung thông báo lỗi - Error message content
	error_position: "top-0 end-0",							// [bootstrap position] Vị trí của thông báo lỗi - Position of the error message 
	prompt: "You are 'YourGPT', a friendly chatbot...",  	// [text] 	Lời nhắc cho YourGPT - Prompt for YourGPT 
	// firestore_config: {	// Bỏ comment để sử dụng tính năng lưu tin nhắn lên FireStore - Uncomment to use the feature to save messages to FireStore
	// 	apiKey: "<API_KEY>",
	// 	authDomain: "<PROJECT_ID>.firebaseapp.com",
	// 	projectId: "<PROJECT_ID>",
	// 	storageBucket: "<PROJECT_ID>.appspot.com",
	// 	messagingSenderId: "<MESSAGING_ID>",
	// 	appId: "<APP_ID>"
	// },
	// firestore_unique: "UniqueID"			// [text] 	Id duy nhất cho cuộc trò chuyện này trên FireStore - Unique id for this chat on FireStore
}
YourGPT.loadModule(YourGPT_Config);         // Run YourGPT Client