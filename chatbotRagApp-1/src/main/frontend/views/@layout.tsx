import {NavLink, Outlet} from "react-router-dom";

export default function Layout(){
	return (
		<div>
		<nav>
			<NavLink to="/">Home</NavLink>
			<NavLink to = "/chat">Chat</NavLink>
			<NavLink to = "/person">Person</NavLink>
		</nav>
		<main>
			<Outlet></Outlet>
		</main>
		</div>
	);
	}