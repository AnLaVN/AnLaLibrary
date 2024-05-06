auto_grow=element=>{element.style.height="";element.style.height=element.scrollHeight+3+"px"};app.controller("YGPT_Controller",["$scope","$compile",function($scope,$compile){$scope.YGPT=YGPT_Config;$scope.Chats=JSON.parse(localStorage.getItem("YGPT"))||[];$scope.Typing="";$scope.Sending=false;$scope.Prompt=YGPT_Config.prompt+($scope.Chats?$scope.Chats.map(o=>(o.ygpt?"YGPT: ":"User: ")+o.content).join("\n\n"):"");$scope.LoadScroll=()=>$scope.YGPT.frame=document.querySelector("#Modal_YGPT .overflow-y-auto");$scope.DeleteChat=()=>{if(confirm(YGPT_Config.delete_confirm_message)){localStorage.removeItem("YGPT");$scope.Chats=[];$scope.Prompt=YGPT_Config.prompt}};$scope.SendMessageOnEnter=event=>{if(event.key==="Enter"&&!event.shiftKey){event.preventDefault();$scope.SendMessage()}};$scope.SendMessage=async function(){if(!$scope.Typing||$scope.Typing=="")return;$scope.Prompt+="\n\nUser: "+$scope.Typing+"\n\nYGPT: ";$scope.Chats.push({content:$scope.Typing,time:new Date,ygpt:false});$scope.Typing="";$scope.Sending=true;var ygpt={prompt:$scope.Prompt,stream:true,n_predict:1e3,temperature:.7,stop:["</s>","YGPT:","User:"],repeat_last_n:256,repeat_penalty:1.18,top_k:40,top_p:.5,min_p:.05,tfs_z:1,typical_p:1,presence_penalty:0,frequency_penalty:0,mirostat:0,mirostat_tau:5,mirostat_eta:.1,grammar:"",n_probs:0,image_data:[],cache_prompt:true,slot_id:0};try{const response=await fetch(`${YGPT_Config.host}/completion`,{method:"POST",body:JSON.stringify(ygpt),headers:{Connection:"keep-alive","Content-Type":"application/json",Accept:"text/event-stream"}});const reader=response.body.getReader();const decoder=new TextDecoder;let content="";let leftover="";$scope.$apply(()=>{$scope.Chats.push({content:content,time:new Date,ygpt:true})});var curr=$scope.Chats.length-1;let cont=true;while(cont){const result=await reader.read();if(result.done)break;const text=leftover+decoder.decode(result.value);const endsWithLineBreak=text.endsWith("\n");let lines=text.split("\n");if(!endsWithLineBreak)leftover=lines.pop();else leftover="";const regex=/^(\S+):\s(.*)$/gm;for(const line of lines){const match=regex.exec(line);if(match){result[match[1]]=match[2];if(result.data){result.data=JSON.parse(result.data);content+=result.data.content;$scope.$apply(()=>{$scope.Chats[curr].content+=result.data.content;$scope.YGPT.frame.scrollTop=$scope.YGPT.frame.scrollHeight});if(result.data.stop){if(result.data.generation_settings)generation_settings=result.data.generation_settings;cont=false;break}}}}}$scope.$apply(()=>{$scope.Sending=false;$scope.Prompt+=content;$scope.Chats[curr].content=content.trim()});document.querySelector("#Modal_YGPT textarea").focus();localStorage.setItem("YGPT",JSON.stringify($scope.Chats))}catch(e){$scope.$apply(()=>{$scope.Sending=false;console.log("error"+e)})}};const YGPT=document.getElementById("YGPT");if(!YGPT.innerHTML){YGPT.innerHTML=`<!doctypehtml><html lang="en"><style>@import url(https://fonts.googleapis.com/css?family=Dosis:300,400,500);*,body,html{font-family:Dosis,sans-serif;transition:background var(--speed) var(--easing)}.w-85{width:85%}.dvh-100{height:100dvh}.c-pointer{cursor:pointer}.pre-wrap{white-space:pre-wrap}:root{--color-scrollbar:rgba(90, 90, 90, 0.3);--color-scrollbar-code:rgba(200, 200, 200, 0.3)}.custom-scroll{scrollbar-width:thin;scrollbar-color:transparent transparent;transition:scrollbar-color .3s ease;-webkit-overflow-scrolling:touch;pointer-events:auto}.custom-scroll::-webkit-scrollbar-thumb{background-color:rgba(0,0,0,0);border-radius:.375rem;box-shadow:0 0 1px rgba(255,255,255,.01)}.custom-scroll:focus,.custom-scroll:focus-within,.custom-scroll:hover{scrollbar-color:var(--color-scrollbar) transparent}.custom-scroll:focus-within::-webkit-scrollbar-thumb,.custom-scroll:focus::-webkit-scrollbar-thumb,.custom-scroll:hover::-webkit-scrollbar-thumb{background-color:var(--color-scrollbar)}body:not(.is-ios) .custom-scroll::-webkit-scrollbar{width:.375rem}</style><button class="p-0 bg-body-tertiary border bottom-0 btn end-0 m-3 overflow-hidden position-fixed rounded-circle text-center"data-bs-target="#Modal_YGPT"data-bs-toggle="modal"style="height:60px;width:60px"type="button"><img class="h-100 w-100"ng-src="{{YGPT.logo}}"></button><div class="fade modal"id="Modal_YGPT"tabindex="-1"><div class="m-0 me-0 modal-dialog ms-auto"><div class="border-0 modal-content"style="background-image:url({{YGPT.pattern}});background-position:top right;background-size:510px auto;background-repeat:repeat"><button class="btn-close end-0 fs-2 m-2 position-absolute top-0"data-bs-dismiss="modal"></button><div class="d-flex container-fluid dvh-100 flex-column"><div class="custom-scroll flex-grow-1 overflow-y-auto row"ng-init="LoadScroll()"><div class="m-0 p-0"><div class="m-0 p-0 justify-content-center row"><div class="text-muted my-3 text-center"><strong>{{YGPT.name}}</strong></div><div class="m-0 p-0 col-12"ng-repeat="Message in Chats track by $index"><div class="d-flex flex-row w-85 justify-content-start"ng-if="Message.ygpt"><img class="border rounded-circle d-none d-sm-block ms-2"ng-src="{{YGPT.logo}}"style="width:2em;height:2em"><div><p class="m-0 p-2 pre-wrap rounded-3 text-break bg-body-tertiary ms-2 text-body">{{Message.content}}<text class="mx-4 spinner-grow"ng-if="Message.content==''"style="width:1.4em;height:1.4em"></text><p class="rounded-3 small text-muted float-end ms-3">{{Message.time | date : 'HH:mm | MMM dd' : 'GMT+7'}}</div></div><div class="d-flex flex-row w-85 justify-content-end ms-auto"ng-if="!Message.ygpt"><div><p class="m-0 p-2 pre-wrap rounded-3 text-break bg-primary me-2 text-white">{{Message.content}}<p class="rounded-3 small text-muted me-3">{{Message.time | date : 'HH:mm | MMM dd' : 'GMT+7'}}</div><img class="border rounded-circle d-none d-sm-block me-2"ng-src="{{YGPT.user_avatar}}"style="width:2em;height:2em"></div></div></div></div></div><div class="d-flex align-items-center col-12 justify-content-center mb-2 mx-auto position-relative"><i class="p-0 bi bi-trash3 c-pointer fs-3 fs-5 me-2 text-{{Sending?'body-tertiary':'danger'}}"ng-click="!Sending && DeleteChat()"></i> <textarea class="custom-scroll form-control"ng-disabled="Sending"ng-keypress="SendMessageOnEnter($event)"ng-model="Typing"onblur="auto_grow(this)"oninput="auto_grow(this)"rows="1"style="resize:none;max-height:150px"></textarea> <i class="bi c-pointer fs-3 bi-send-fill fw-blod ms-2 text-{{Sending?'body-tertiary':'success'}}"ng-click="!Sending && SendMessage()"></i></div></div></div></div></div>`;$compile(YGPT)($scope)}}]);