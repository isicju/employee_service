import React from 'react';
import ReactDOM from 'react-dom';
import Table from '@material-ui/core/Table';
import FormControl from '@material-ui/core/FormControl';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Grid from '@material-ui/core/Grid';
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";


class EmployeeTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {rows: []};
    }

    componentDidMount() {
        fetch('http://localhost:8080/employees/')
            .then(response => response.json())
            .then(response => {
                let newRows = [];
                response.forEach((record) => {
                    newRows.push({
                        id: record.id, firstName: record.firstName, lastName: record.lastName, salary: record.salary,
                        hireDate: record.hireDate
                    })
                });
                this.setState({rows: newRows});
            });
    }

    render() {
        return (
            <TableContainer>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>First Name</TableCell>
                            <TableCell>Last Name</TableCell>
                            <TableCell>Salary</TableCell>
                            <TableCell>Hire Date</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.state.rows.map((row) => (
                            <TableRow onClick={() => this.props.clickHandler(row.id)} key={row.id}>
                                <TableCell>{row.firstName}</TableCell>
                                <TableCell>{row.lastName}</TableCell>
                                <TableCell>{row.salary}</TableCell>
                                <TableCell>{row.hireDate}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        );
    }
}

const divStyle = {
    background: "#eee",
    margin: "5px"
};


class EmployeeDetails extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: "", firstName: "", lastName: "", salary: "",
            location: "", jobTitle: "", departmentName: "",
            managerName: "", email: "", reportMessage: ""
        };

        this.sendEmail = this.sendEmail.bind(this);
        this.onEmailUpdate = this.onEmailUpdate.bind(this);
        this.onReportUpdate = this.onReportUpdate.bind(this);
    }

    componentWillReceiveProps(newProps) {
        fetch('http://localhost:8080/employees/details/' + newProps.employeeDetailsProps.id)
            .then(response => response.json())
            .then(response => {
                this.setState({
                    id: response.id,
                    firstName: response.firstName,
                    lastName: response.lastName,
                    salary: response.salary,
                    location: response.location,
                    jobTitle: response.jobTitle,
                    departmentName: response.departmentName,
                    managerName: response.managerName,
                    email: "",
                    reportMessage: ""
                });
            });
    }

    sendEmail() {

        console.log("report message: " + this.state.reportMessage);
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({
                email: this.state.email,
                employeeId: this.state.id,
                reportMessage: this.state.reportMessage ? this.state.reportMessage :  "AAAAAAAAAOH EBAAAAAAAAA"
            })
        };
        fetch('http://localhost:8080/employees/mail/', requestOptions)
            .then(response => response.json())
            .then(response => {
                alert("email was sent!");
            }).catch(function (error) {
            alert("Error sending email")
        });
    }

    onEmailUpdate(newValue){
        this.setState({email:newValue.target.value});
    }

    onReportUpdate(newValue){
        this.setState({reportMessage:newValue.target.value});
    }

    render() {
        return (
            <FormControl fullWidth>
                <TextField
                    InputLabelProps={{shrink: true}}
                    value={this.state.firstName}
                    disabled
                    style={divStyle}
                    id="name"
                    label="Employee Name"
                    variant="outlined"
                />
                <TextField
                    disabled
                    InputLabelProps={{shrink: true}}
                    value={this.state.lastName}
                    style={divStyle}
                    id="lastName"
                    label="Employee Last Name"
                    variant="outlined"
                />
                <TextField
                    disabled
                    InputLabelProps={{shrink: true}}
                    value={this.state.jobTitle}
                    style={divStyle}
                    id="jobId"
                    label="Job Title"
                    variant="outlined"
                />
                <TextField
                    disabled
                    InputLabelProps={{shrink: true}}
                    value={this.state.departmentName}
                    style={divStyle}
                    id="departmentId"
                    label="Department Name"
                    variant="outlined"
                />
                <TextField
                    disabled
                    InputLabelProps={{shrink: true}}
                    value={this.state.salary}
                    style={divStyle}
                    label="Salary"
                    variant="outlined"
                    type="number"
                />
                <TextField
                    disabled
                    InputLabelProps={{shrink: true}}
                    value={this.state.location}
                    style={divStyle}
                    label="Location"
                    variant="outlined"
                />
                <TextField
                    disabled
                    InputLabelProps={{shrink: true}}
                    value={this.state.managerName}
                    style={divStyle}
                    label="Manager"
                    variant="outlined"
                />
                <TextField
                    value={this.state.reportMessage}
                    style={divStyle}
                    label="Comments to Report"
                    variant="outlined"
                    onChange={this.onReportUpdate}
                />
                <TextField
                    value={this.state.email}
                    style={divStyle}
                    id="location"
                    label="Email to sent"
                    variant="outlined"
                    onChange={this.onEmailUpdate}
                />
                <Button onClick={this.  sendEmail} variant="contained" color="primary">
                    Send Email
                </Button>
            </FormControl>
        );
    }
}


class EmployeeWrapper extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employeeDetailsState: {
                name: 'John', lastName: 'Smith', jobTitle: 'Dev', department: 'IT', salary: 12333,
                manager: 'Mary Smith', location: 'San Francisco'
            }
        };
    }

    onComponentMount() {
        this.state = {
            employeeDetailsState: {
                name: 'John', lastName: 'Smith', jobTitle: 'Dev', department: 'IT', salary: 12333,
                manager: 'Mary Smith', location: 'San Francisco'
            }
        };
    }

    onEmployeeSelectedListener = (employeeId) => {
        console.log("works: " + employeeId);
        this.setState({employeeDetailsState: {id: employeeId}})
    };

    render() {
        return (<Grid container>
            <Grid item sm={12} md={6}>
                <EmployeeTable clickHandler={this.onEmployeeSelectedListener}/>
            </Grid>
            <Grid item sm={12} md={6}>
                <EmployeeDetails employeeDetailsProps={this.state.employeeDetailsState}/>
            </Grid>
        </Grid>);
    }

}


ReactDOM.render(
    <EmployeeWrapper/>,
    document.getElementById('root')
);
