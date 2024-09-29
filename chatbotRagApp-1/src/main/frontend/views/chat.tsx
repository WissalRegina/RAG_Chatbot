import {TextField,Button} from "@vaadin/react-components"
import { ChatAiService } from "Frontend/generated/endpoints";
import { useState } from "react";


export default function Chat(){
	const [question,setQuestion]= useState<string>("");
	const [response,setResponse]=useState<string>("");
	
	async function send(){
		ChatAiService.ragChat(question).then(resp=>{
			setResponse(resp)
		});
	}
	return(
		<div>
			<h3>chat bot</h3> 
		
		<div>
			<TextField onChange={(e=>setQuestion(e.target.value))}/>
			<Button onClick={send}>Send</Button>
			<div>
				<pre>
					{response}
				</pre>
			</div>
		</div>
		</div>
	);
	
	
}