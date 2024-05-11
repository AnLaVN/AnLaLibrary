const YGPT_Config = {	// Thay đổi giá trị cấu hình phù hợp với bạn, Change the config value as appropriate for you
    host: "http://localhost:3000",			// [url] 				Địa chủ máy chủ của YGPT - YGPT server address
    logo: "logo_icon.png",					// [url of path] 		Logo hiển thị của YGPT - YGPT display logo
    pattern: "pattern-dark.png",			// [url of path]		Hình nền pattern - Pattern wallpaper
    name: "YGPT Assistant",					// [text] 				Tên hiển thị của YGPT - YGPT display name
    tutorial: "Let ask YGPT anything...",	// [text] 				Hướng dẫn nhỏ - Small guide
    send_icon: "bi-arrow-up-right-circle",	// [bootstrap icon]  	Icon gửi tin nhắn - Message sending icon
    delete_icon: "bi-trash",				// [bootstrap icon] 	Icon xoá tin nhắn - Message deletion icon
    datetime_format: "HH:mm | MMM dd",		// [DateTime pattern]	Định dạng ngày giờ - Date time format
    timezone_format: "GMT+7",				// [TimeZone] 			Định dạng múi giờ - Time zone format
    width: "90%",							// [percent] 			Chiều dài bong bóng chat - Chat bubble length
    user_text: "light",						// [bootstrap colors]	Màu chữ bong bóng chat của người dùng - User chat bubble text color
    user_color: "#A15BFC",//primary			// [bootstrap bg-color or HEX] Màu icon gửi tin nhắn và bong bóng chat của người dùng - Color of send message icon and user chat bubble
    user_avatar: "https://github.com/AnLaVN.png",// [url of path] 	Avatar hiển thị của người dùng - User displayed avatar
    title_message: "YGPT Notification",					// [text] 	Tiêu đề thông báo - Notification title
    clear_message: "Are you want to delete this chat?",	// [text] 	Xác nhận xoá tin nhắn - Confirm delete message
    error_message: "YGPT got error, please try later !",// [text] 	Nội dung thông báo lỗi - Error message content
    error_position: "top-0 end-0",			// [bootstrap position] Vị trí của thông báo lỗi - Position of the error message 
    prompt: "You are 'YGPT', a friendly chatbot."  		// [text] 	Lời nhắc cho YGPT - Prompt for YGPT 
}