import ReactECharts from 'echarts-for-react';  

function NumberOfStudents(props) {
    
    const option = {
        title: {
            text: 'Number Of Student',
            subtext: 'Per Location',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left'
        },
        series: [
            {
                name: 'Location',
                type: 'pie',
                radius: '50%',
                data: [
                    { value: 100, name: 'Iowa' },
                    { value: 150, name: 'Chicago' },
                    { value: 40, name: 'New York' },
                    { value: 500, name: 'San Franscisco' },
                    { value: 1000, name: 'Texas' }
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    return (<div className='card'>
        
        <ReactECharts
            option={option}
            notMerge={true}
            lazyUpdate={true}
            theme={"theme_name"}
            style={{ height: '500px', width: '100%' }}

        />
    </div>);
}

export default NumberOfStudents;