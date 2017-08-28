(function() {
	let app = angular.module('webSocket',[]);
	let WebSocketCtrl = function($scope){
		$scope.name = 'Narender Singh';
		console.log("WS ctrl");
		
		let stompClient = null;
		$scope.logonedUser;

		function setConnected(connected) {
			$("#connect").prop("disabled", connected);
			$("#disconnect").prop("disabled", !connected);
			if (connected) {
				$("#conversation").show();
			} else {
				$("#conversation").hide();
			}
			$("#greetings").html("");
		}

		function connect() {
			var socket = new SockJS('/gs-guide-websocket');
			stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame) {
				setConnected(true);
				console.log('Connected: ' + frame);
				logonedUser = frame.headers['user-name']
				$('#username').html(logonedUser);
				stompClient.subscribe('/topic/greetings', function(greeting) {
					showMessage(JSON.parse(greeting.body));
				});
			});
		}

		function disconnect() {
			if (stompClient != null) {
				stompClient.disconnect();
			}
			setConnected(false);
			console.log("Disconnected");
		}

		function sendName() {
			if(stompClient.connected){
				stompClient.send("/app/hello", {}, JSON.stringify({
					'from' : logonedUser,
					'message' : $('#message').val(),
					'time' : new Date()
				}));
			}else{
				connect();
			}
		}

		function showMessage(data) {
			$("#messages").append(
					"<tr><td>" + data.from + ": </td> <td> " + data.message
					+ " </td> <td> Last Seen " + new Date(data.time)
					+ "</td></tr>");
		}

		$(function() {
			connect();
			$("form").on('submit', function(e) {
				e.preventDefault();
			});
			/*$("#connect").click(function() {
				connect();
			});*/
			$("#disconnect").click(function() {
				disconnect();
			});
			$("#send").click(function() {
				sendName();
			});
		});
	}
	
	app.controller("WebSocketCtrl",['$scope',WebSocketCtrl]);
	
	
})();
