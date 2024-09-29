import { useRef, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import API, { endpoints } from "../../configs/API";

const Register = () => {
    const fields = [{
        label: "Tên người dùng",
        type: "text",
        field: "firstName"
    },{
        label: "Tên đăng nhập",
        type: "text",
        field: "username"
    }, {
        label: "avatar",
        type: "text",
        field: "avatar"
    }, {
        label: "Mật khẩu",
        type: "password",
        field: "password"
    },{
        label: "Xác nhận mật khẩu",
        type: "password",
        field: "confirm"
    }];

    const [user, setUser] = useState({});
    const avatar = useRef();
    const nav = useNavigate();

    const change = (e, field) => {
        setUser(current => {
            return {...current, [field]: e.target.value}
        })
    }

    const register = async (e) => {
        e.preventDefault();

        let form = new FormData();
        for (let key in user)
            if (key !== 'confirm')
                form.append(key, user[key]);

        if (avatar)
            form.append('file', avatar.current.files[0]);

        try {
            let res = await API.post(endpoints['register'], form, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
            if (res.status === 201)
                nav("/login");
        } catch (ex) {
            console.error(ex);
        }
    }

    return (
        <h1></h1>
    );
}

export default Register;