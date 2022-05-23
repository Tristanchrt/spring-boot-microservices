import React from 'react'
import { Table, Avatar, Tag } from 'antd';
import { useDispatch,  } from "react-redux";
import { selectedCard } from '../../core/actions/cardAction'
import { getCard } from '../../core/services/CardService';

export const List = (props) => {
    
    const dispatch = useDispatch();
    const onClickCard = async (data) => {
        const card = await getCard(data.key);
        dispatch(selectedCard(card));
    }

    const columns = [
        {
            title: "",
            dataIndex: "image_url",
            key: "image",
            render : (imgSrc) => <Avatar src={imgSrc} />,
        },
        {
            title: 'Name',
            dataIndex: 'name',
            key: 'name',
        },
        {
            title: 'Description',
            dataIndex: 'description',
            key: 'description',
        },
        {
            title: 'Family',
            dataIndex: 'family',
            key: 'family',
        },
        {
            title: 'Affinity',
            dataIndex: 'affinity',
            key: 'affinity',
        },
        {
            title: 'Hp',
            dataIndex: 'hp',
            key: 'hp',
        },
        {
            title: 'Energy',
            dataIndex: 'energy',
            key: 'energy',
        },
        {
            title: 'Attack',
            dataIndex: 'attack',
            key: 'attack',
        },
        {
            title: 'Defense',
            dataIndex: 'defense',
            key: 'defense',
        },
        {
            title: 'Price',
            dataIndex: 'price',
            key: 'price',
            render : (price) => "$" + price
        },
        {
            title : "Statut",
            dataIndex: "is_to_sell",
            key: "is_to_sell",
            render : (is_to_sell) => <Tag color={is_to_sell ? "blue" : "orange"}>{is_to_sell ? "In Store" : "Owned"}</Tag>
        }
    ];

    return (
        <>
            <Table pagination={false} onRow={(record, rowIndex) => {
                return {
                    onClick: event => {
                        onClickCard(record)
                    },
                };
            }} dataSource={props.dataSource} columns={columns} />
        </>
    )
}

export default List;