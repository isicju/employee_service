import React from 'react';
import ReactDOM from 'react-dom';
import TextField from "@material-ui/core/TextField";
import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody";

class EmployeeTable extends React.Component {

    constructor(){
        super();
        this.state = {rows:[]}
    }

    componentWillMount() {
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
        return(
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
                            <TableRow >
                                <TableCell>{row.firstName}</TableCell>
                                <TableCell>{row.lastName}</TableCell>
                                <TableCell>{row.salary}</TableCell>
                                <TableCell>{row.hireDate}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        )
    }

}

ReactDOM.render(
    <EmployeeTable/>,
    document.getElementById('root')
);
