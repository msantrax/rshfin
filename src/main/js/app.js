'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const when = require('when');
const client = require('./client');
const follow = require('./follow'); // function to hop multiple links by "rel"

import {useState} from 'react';

import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Collapse from 'react-bootstrap/Collapse';
import Card from 'react-bootstrap/Card';

const root = '/api';


class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {headers: []};

		this.state.pageSize = 5;
	}

	componentDidMount() {
		// client({method: 'GET', path: '/api/headers'})
		// 	.done(response => {
		// 		this.setState({headers: response.entity._embedded.headers});
		// 	});
		this.loadFromServer(this.state.pageSize);
	}

	loadFromServer(pageSize) {
		follow(client, root, [ {rel: 'headers', params: {size: pageSize}}])
			.then(headerCollection => {
				return client({
					method: 'GET',
					path: headerCollection.entity._links.profile.href,
					headers: {'Accept': 'application/schema+json'}
				})
				.then(schema => {
					this.schema = schema.entity;
					return headerCollection;
				});
			})
			.done(headerCollection => {
				this.setState({
					headers: headerCollection.entity._embedded.headers,
					attributes: Object.keys(this.schema.properties),
					pageSize: pageSize,
					links: headerCollection.entity._links});
			});
	}



	render() {
		return (
			<Container className="p-3 fluid">
				<Container className="p-5 mb-4 bg-light rounded-3">
					<h1 className="header">RSHFIN testbench - V3</h1>
					<HeaderList headers={this.state.headers}/>
					{/*<ShowCard sc={this.state.headers}/>*/}
					<ShowCard />
				</Container>
			</Container>

		)
	}
}


function ShowCard () {

	const [open, setOpen] = useState(false);

	return (
		<>
		<Button
			onClick={() => setOpen(!open)}
			aria-controls="example-collapse-text"
			aria-expanded={open}
		>
			click
		</Button>

		<div style={{minHeight: '150px'}}>
			<Collapse in={open} dimension="width">
				<div id="example-collapse-text">
					<Card body style={{width: '400px'}}>
						Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus
						terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer
						labore wes anderson cred nesciunt sapiente ea proident.
					</Card>
				</div>
			</Collapse>
		</div>
		</>
	);

}


class HeaderList extends React.Component{

	render() {
		const headers = this.props.headers.map(header =>
			<Header key={header._links.self.href} header={header}/>
		);
		return (
			<table>
				<tbody>
				<tr>
					<th>SID</th>
					<th>Type</th>
					<th>Lote</th>
				</tr>
				{headers}
				</tbody>
			</table>
		)
	}
}


class Header extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.header.sid}</td>
				<td>{this.props.header.type}</td>
				<td>{this.props.header.lote}</td>
			</tr>
		)
	}
}


ReactDOM.render(
	<App />,
	document.getElementById('react')
)







//
// class HeaderList extends React.Component {
//
//
// 	constructor(props) {
// 		super(props);
// 		this.state = {headers: []};
// 	}
//
// 	componentDidMount() {
// 		client({method: 'GET', path: '/api/headers'}).done(response => {
// 			this.setState({headers: response.entity._embedded.headers});
// 		});
// 	}
//
// 	render() {
// 		return (
// 			<HeaderList headers={this.state.headers}/>
// 		)
// 	}
//
//
// 	constructor(props) {
// 		super(props);
// 		this.handleNavFirst = this.handleNavFirst.bind(this);
// 		this.handleNavPrev = this.handleNavPrev.bind(this);
// 		this.handleNavNext = this.handleNavNext.bind(this);
// 		this.handleNavLast = this.handleNavLast.bind(this);
// 		this.handleInput = this.handleInput.bind(this);
// 	}
//
// 	// tag::handle-page-size-updates[]
// 	handleInput(e) {
// 		e.preventDefault();
// 		const pageSize = ReactDOM.findDOMNode(this.refs.pageSize).value;
// 		if (/^[0-9]+$/.test(pageSize)) {
// 			this.props.updatePageSize(pageSize);
// 		} else {
// 			ReactDOM.findDOMNode(this.refs.pageSize).value = pageSize.substring(0, pageSize.length - 1);
// 		}
// 	}
// 	// end::handle-page-size-updates[]
//
// 	// tag::handle-nav[]
// 	handleNavFirst(e){
// 		e.preventDefault();
// 		this.props.onNavigate(this.props.links.first.href);
// 	}
// 	handleNavPrev(e) {
// 		e.preventDefault();
// 		this.props.onNavigate(this.props.links.prev.href);
// 	}
// 	handleNavNext(e) {
// 		e.preventDefault();
// 		this.props.onNavigate(this.props.links.next.href);
// 	}
// 	handleNavLast(e) {
// 		e.preventDefault();
// 		this.props.onNavigate(this.props.links.last.href);
// 	}
// 	// end::handle-nav[]
// 	// tag::employee-list-render[]
// 	render() {
// 		const headers = this.props.headers.map(header =>
// 			<Header key={header.entity._links.self.href}
// 					  employee={header}
// 					  attributes={this.props.attributes}
// 					  onUpdate={this.props.onUpdate}
// 					  onDelete={this.props.onDelete}/>
// 		);
//
// 		const navLinks = [];
// 		if ("first" in this.props.links) {
// 			navLinks.push(<button key="first" onClick={this.handleNavFirst}>&lt;&lt;</button>);
// 		}
// 		if ("prev" in this.props.links) {
// 			navLinks.push(<button key="prev" onClick={this.handleNavPrev}>&lt;</button>);
// 		}
// 		if ("next" in this.props.links) {
// 			navLinks.push(<button key="next" onClick={this.handleNavNext}>&gt;</button>);
// 		}
// 		if ("last" in this.props.links) {
// 			navLinks.push(<button key="last" onClick={this.handleNavLast}>&gt;&gt;</button>);
// 		}
//
// 		return (
// 			<div>
// 				<input ref="pageSize" defaultValue={this.props.pageSize} onInput={this.handleInput}/>
// 				<table>
// 					<tbody>
// 						<tr>
// 							<th>SID</th>
// 							<th>Type</th>
// 							<th>Lote</th>
// 							<th></th>
// 							<th></th>
// 						</tr>
// 						{headers}
// 					</tbody>
// 				</table>
// 				<div>
// 					{navLinks}
// 				</div>
// 			</div>
// 		)
// 	}
// 	// end::employee-list-render[]
// }
//
//
// class Header extends React.Component {
//
// 	constructor(props) {
// 		super(props);
// 		this.handleDelete = this.handleDelete.bind(this);
// 	}
//
// 	handleDelete() {
// 		this.props.onDelete(this.props.header);
// 	}
//
// 	render() {
// 		return (
// 			<tr>
// 				<td>{this.props.header.entity.sid}</td>
// 				<td>{this.props.header.entity.type}</td>
// 				<td>{this.props.header.entity.lote}</td>
// 				{/*<td>*/}
// 				{/*	<UpdateDialog employee={this.props.employee}*/}
// 				{/*				  attributes={this.props.attributes}*/}
// 				{/*				  onUpdate={this.props.onUpdate}/>*/}
// 				{/*</td>*/}
// 				{/*<td>*/}
// 				{/*	<button onClick={this.handleDelete}>Delete</button>*/}
// 				{/*</td>*/}
// 			</tr>
// 		)
// 	}
// }
//




// // <HeaderList headers={this.state.headers}/>
// <div>
// <input ref="pageSize" defaultValue={this.props.pageSize} onInput={this.handleInput}/>
// <table>
// 	<tbody>
// 	<tr>
// 		<th>ID1</th>
// 		<th>SID</th>
// 		<th>Type</th>
//
// 		<th>Lote</th>
// 		<th>Density</th>
// 	</tr>
// 	{/*{headers}*/}
// 	</tbody>
// </table>
// <div>
// 	{/*{navLinks}*/}
// </div>
// </div>