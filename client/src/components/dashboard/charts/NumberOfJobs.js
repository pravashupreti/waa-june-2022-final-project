import ReactECharts from 'echarts-for-react';  

function NumberOfJobs() {

    const option = {
        title: {
            text: 'Number Of Jobs',
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
                    { value: 10, name: 'Iowa (10)' },
                    { value: 20, name: 'Chicago (20)' },
                    { value: 30, name: 'New York (30)' },
                    { value: 40, name: 'San Franscisco (40)' },
                    { value: 80, name: 'Texas (80)' }
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

export default NumberOfJobs;